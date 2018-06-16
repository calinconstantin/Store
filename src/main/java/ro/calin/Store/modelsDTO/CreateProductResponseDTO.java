package ro.calin.Store.modelsDTO;

public class CreateProductResponseDTO {
    private boolean fullNameNull=false;
    private boolean fullNameNok=false;
    private boolean priceNull=false;
    private boolean priceNok=false;
    private boolean stockNull=false;
    private boolean stockNok=false;

    public boolean isFullNameNull() {
        return fullNameNull;
    }

    public void setFullNameNull(boolean fullNameNull) {
        this.fullNameNull = fullNameNull;
    }

    public boolean isFullNameNok() {
        return fullNameNok;
    }

    public void setFullNameNok(boolean fullNameNok) {
        this.fullNameNok = fullNameNok;
    }

    public boolean isPriceNull() {
        return priceNull;
    }

    public void setPriceNull(boolean priceNull) {
        this.priceNull = priceNull;
    }

    public boolean isPriceNok() {
        return priceNok;
    }

    public void setPriceNok(boolean priceNok) {
        this.priceNok = priceNok;
    }

    public boolean isStockNull() {
        return stockNull;
    }

    public void setStockNull(boolean stockNull) {
        this.stockNull = stockNull;
    }

    public boolean isStockNok() {
        return stockNok;
    }

    public void setStockNok(boolean stockNok) {
        this.stockNok = stockNok;
    }
}
