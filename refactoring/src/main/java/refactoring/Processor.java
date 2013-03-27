package refactoring;

import java.math.BigDecimal;
import java.util.List;

public class Processor {

    private String firstName ;
    private String lastName;
    private String street;
    private String houseNo;
    private String addInfo;
    private String zipCode;
    private String city;
    private BigDecimal sum = BigDecimal.ZERO;
    private boolean packStation = false;
    private Address b;
    private Address d;
    private Order o;

    public void process(final Order order, final ShoppingCart sc) {
        o = order;
        o.setValid(true);
        Carrier carrier = sc.getCarrier();
        //Addresses
        setLastName(sc, false);
        setStreet(sc, false);
        setHouseNo(sc, false);
        setZipCode(sc, false);
        setCity(sc, false);

        if(sc.getShippingAddressFirstname() != null && sc.getShippingAddressFirstname().length() > 0
            && sc.getShippingAddressAdditionalInformation() != null && sc.getShippingAddressAdditionalInformation().length() > 0) {
            setFirstName(sc, false);
            d = new Address(lastName, firstName, street, houseNo, addInfo, zipCode, city, sc.getShippingCountry().getCountry().toUpperCase());
        } else {
            if(sc.getShippingAddressFirstname() != null && sc.getShippingAddressFirstname().length() > 0) {
                setFirstName(sc, false);
                d = new Address(lastName, firstName, street, houseNo, addInfo, zipCode, city, sc.getShippingCountry().getCountry().toUpperCase());
            } else {
                if(sc.getShippingAddressAdditionalInformation() == null && sc.getShippingAddressAdditionalInformation().length() == 0) {
                    if(sc.getShippingCountry().getCountry().equalsIgnoreCase("DE")) {
                        d = new Address(lastName, street, houseNo, zipCode, city);
                    } else {
                        d = new Address(lastName, street, houseNo, zipCode, city, sc.getShippingCountry().getCountry().toUpperCase());
                    }
                } else {
                    if(sc.getShippingAddressAdditionalInformation().length() <= 20) {
                        addInfo = sc.getShippingAddressAdditionalInformation();
                    } else {
                        addInfo = sc.getShippingAddressAdditionalInformation().substring(0,17) + "...";
                    }
                    d = new Address(lastName, firstName, street, houseNo, addInfo, zipCode, city, sc.getShippingCountry().getCountry().toUpperCase());
                    addInfo = null;
                }
            }
        }
        hasSame(sc);
        o.setDelivery(d);
        setLastName(sc, true);
        setStreet(sc, true);
        setHouseNo(sc, true);
        setZipCode(sc, true);
        setCity(sc, true);
        if(sc.getBillingAddressFirstname() != null && sc.getBillingAddressFirstname().length() > 0) {
            setFirstName(sc, true);
            b = new Address(lastName, firstName, street, houseNo, addInfo, zipCode, city, sc.getBillingCountry().getCountry());
        } else {
            if(sc.getShippingCountry().getCountry().equalsIgnoreCase("DE")) {
                b = new Address(lastName, street, houseNo, zipCode, city);
            } else {
                b = new Address(lastName, street, houseNo, zipCode, city, sc.getShippingCountry().getCountry().toUpperCase());
            }
        }
        o.setBilling(b);
        if(b.getStreet() == null || b.getStreet().length() == 0) {
            o.setValid(false);
        } else {
            packStation = b.getStreet().equalsIgnoreCase("packstation");
            if(!packStation) {
                if(d.getStreet() == null || d.getStreet().length() == 0) {
                    o.setValid(false);
                } else {
                    packStation = d.getStreet().equalsIgnoreCase("packstation");
                    if(!packStation && d.getAddInfo() != null) {
                        packStation = d.getAddInfo().equalsIgnoreCase("packstation");
                    }
                }
            } else {
                o.setValid(false);
            }
        }
        //calculate SUM
        if(sc.getItems().size() > 0) {
            for(int i=0; i < sc.getItems().size(); i++) {
                if(sc.getItems().get(i).getQuantity() == 0) {
                    o.setValid(false);
                    break;
                }
                if(sc.getItems().get(i).getQuantity() == 1) {
                    sum = sum.add(sc.getItems().get(i).getPrice());
                    continue;
                } else {
                    BigDecimal itemSum = BigDecimal.ZERO;
                    for(int x=0; x < sc.getItems().get(i).getQuantity(); x++) {
                        if(sc.getItems().get(i).getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                            break;
                        }
                        itemSum = itemSum.add(sc.getItems().get(i).getPrice());
                    }
                    sum = sum.add(itemSum);
                }
            }
            o.setOrderSum(sum);
        } else {
            o.setValid(false);
        }

        //Carrier
        if(o.getDelivery() == null) {
            o.setValid(false);
            return;
        } else {
            BigDecimal sumOrg = sum;
            for(int i=0; i < Carrier.carriers.length; i++) {
                calculateCarrier(Carrier.carriers[i], false);
                if(o.isValid() && sumOrg.compareTo(sum) == -1) {
                    if(containBulky(sc.getItems())) {
                        for(int z=0; z < Carrier.carriers.length; z++) {
                            if(CarrierCosts.valueOf(Carrier.carriers[z]).getBulkyCost() != null) {
                                sum = sumOrg;
                                calculateCarrier(Carrier.carriers[z], true);
                                break;
                            }
                        }
                        if(sumOrg.compareTo(sum) == -1) {
                            o.setOrderSum(sum);
                            break;
                        } else {
                            o.setValid(false);
                        }
                    } else {
                        o.setOrderSum(sum);
                        break;
                    }
                }
            }

            if(sumOrg.compareTo(sum) >= 0) {
                o.setValid(false);
            }
        }


    }

    private boolean containBulky(final List<Item> items) {
        boolean bulkyFreight = false;
        for(int i=0; i < items.size(); i++) {
            if(items.get(i).isBulky()) {
                bulkyFreight = true;
                break;
            }
        }
        if(!bulkyFreight) {
            bulkyFreight = false;
        }

        return bulkyFreight;
    }

    private void calculateCarrier(Carrier carrier, final boolean bulkyFreight) {
        if(!calculateForPackstation(bulkyFreight) && o.isValid()) {
            for(int i=0; i < carrier.getLocales().length; i++) {
                CarrierCosts.Cost cost;
                if(bulkyFreight) {
                    cost = CarrierCosts.valueOf(carrier).getBulkyCost();
                    if(cost.getLocale().equals(d.getCountryIsoCode())) {
                        sum = sum.add(cost.getPrice());
                        break;
                    }
                } else  if(carrier.getLocales()[i].equals(d.getCountryIsoCode())) {
                    if((cost = getCosts(CarrierCosts.valueOf(carrier).getCosts(), carrier.getLocales()[i])) != null) {
                        sum = sum.add(cost.getPrice());
                    } else {
                        o.setValid(false);
                    }
                }
            }
        }
    }

    private boolean calculateForPackstation(final boolean bulkyFreight) {
        if(packStation && !bulkyFreight) {
            for(int i=0; i < Carrier.DHL.getLocales().length; i++) {
                CarrierCosts.Cost cost = getCosts(CarrierCosts.valueOf(Carrier.DHL).getCosts(), Carrier.DHL.getLocales()[i]);
                if(cost != null) {
                    sum = sum.add(cost.getPrice());
                    return true;
                }
            }
        }

        if(packStation && bulkyFreight) {
            o.setValid(false);
            return false;
        }

        return false;
    }

    private CarrierCosts.Cost getCosts(final CarrierCosts.Cost[] costs, final String locale) {
        for(int i=0; i < costs.length; i++) {
            if(costs[i].getLocale().equals(locale)) {
                return costs[i];
            }
        }

        return null;
    }

    private boolean hasSame(final ShoppingCart sc) {
        if(d.getLastname() == sc.getBillingAddressLastname() && d.getFirstname() == sc.getBillingAddressFirstname()
            && d.getStreet() == sc.getBillingAddressStreet() && d.getHouseNo() == sc.getBillingAddressHouseNo()
            && d.getZipCode() == sc.getBillingAddressZipCode() && d.getCity() == sc.getBillingAddressCity()) {
            return true;
        }
        return false;
    }

    private void setFirstName(ShoppingCart sc, boolean billing) {
        if(billing) {
            if(sc.getBillingAddressFirstname().length() <= 20) {
                firstName = sc.getBillingAddressFirstname();
            } else {
                firstName = sc.getBillingAddressFirstname().substring(0,17) + "...";
            }
        } else {
            if(sc.getShippingAddressFirstname().length() <= 20) {
                firstName = sc.getShippingAddressFirstname();
            } else {
                firstName = sc.getShippingAddressFirstname().substring(0,17) + "...";
            }
        }
    }

    private void setLastName(ShoppingCart sc, boolean billing) {
        if(billing) {
            if(sc.getBillingAddressLastname() != null && sc.getBillingAddressLastname().length() > 0) {
                if(sc.getBillingAddressLastname().length() <= 20) {
                    lastName = sc.getBillingAddressLastname();
                } else {
                    lastName = sc.getBillingAddressLastname().substring(0,17) + "...";
                }
            }
        } else {
            if(sc.getShippingAddressLastname() != null && sc.getShippingAddressLastname().length() > 0) {
                if(sc.getShippingAddressLastname().length() <= 20) {
                    lastName = sc.getShippingAddressLastname();
                } else {
                    lastName = sc.getShippingAddressLastname().substring(0,17) + "...";
                }
            }
        }
    }

    private void setStreet(ShoppingCart sc, boolean billing) {
        if(billing) {
            if(sc.getBillingAddressStreet() != null && sc.getBillingAddressStreet().length() > 0) {
                if(sc.getBillingAddressStreet().length() <= 50) {
                    street = sc.getBillingAddressStreet();
                } else {
                    street = sc.getBillingAddressStreet().substring(0,47) + "...";
                }
            }
        } else {
            if(sc.getShippingAddressStreet() != null && sc.getShippingAddressStreet().length() > 0) {
                if(sc.getShippingAddressStreet().length() <= 50) {
                    street = sc.getShippingAddressStreet();
                } else {
                    street = sc.getShippingAddressStreet().substring(0,47) + "...";
                }
            }
        }
    }

    private void setZipCode(ShoppingCart sc, boolean billing) {
        if(billing) {
            if(sc.getBillingAddressZipCode() != null && sc.getBillingAddressZipCode().length() == 5) {
                zipCode = sc.getBillingAddressZipCode();
            }
        } else {
            if(sc.getShippingAddressZipCode() != null && sc.getShippingAddressZipCode().length() == 5) {
                zipCode = sc.getShippingAddressZipCode();
            }
        }
    }

    private void setCity(ShoppingCart sc, boolean billing) {
        if(billing) {
            if(sc.getBillingAddressCity() != null && sc.getBillingAddressCity().length() > 0) {
                if(sc.getBillingAddressCity().length() <= 30) {
                    city = sc.getBillingAddressCity();
                } else {
                    city = sc.getBillingAddressCity().substring(0,17) + "...";
                }
            }
        } else {
            if(sc.getShippingAddressCity() != null && sc.getShippingAddressCity().length() > 0) {
                if(sc.getShippingAddressCity().length() <= 30) {
                    city = sc.getShippingAddressCity();
                } else {
                    city = sc.getShippingAddressCity().substring(0,17) + "...";
                }
            }
        }
    }

    private void setHouseNo(ShoppingCart sc, boolean billing) {
        if(billing) {
            if(sc.getBillingAddressHouseNo() != null && sc.getBillingAddressHouseNo().length() > 0) {
                if(sc.getBillingAddressHouseNo().length() <= 10) {
                    houseNo = sc.getBillingAddressHouseNo();
                } else {
                    houseNo = sc.getBillingAddressHouseNo().substring(0,7) + "...";
                }
            }
        } else {
            if(sc.getShippingAddressHouseNo() != null && sc.getShippingAddressHouseNo().length() > 0) {
                if(sc.getShippingAddressHouseNo().length() <= 10) {
                    houseNo = sc.getShippingAddressHouseNo();
                } else {
                    houseNo = sc.getShippingAddressHouseNo().substring(0,7) + "...";
                }
            }
        }
    }
}
