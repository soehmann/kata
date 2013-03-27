package refactoring;

public class ProcessedOrderValidator {

    public void validate(final Order o) {
        if(!o.isValid()) {
            throw new IllegalStateException("Order is invalid");
        }

        if(o.getBilling() == null || o.getDelivery() == null) {
            throw new IllegalStateException("Order is invalid");
        }

        validateInput(o.getDelivery());
        validateInput(o.getBilling());
    }

    private void validateInput(final Address address) {
        isInvalidInput(address.getFirstname());
        isInvalidInput(address.getLastname());
        isInvalidInput(address.getStreet());
        isInvalidInput(address.getHouseNo());
        isInvalidInput(address.getZipCode());
        isInvalidInput(address.getCity());
    }

    private void isInvalidInput(final String input) {
        if(input == null || input.length() == 0) {
            throw new IllegalStateException("Order is invalid");
        }
    }
}
