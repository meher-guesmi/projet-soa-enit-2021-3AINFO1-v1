package enit.bank.Domain;

public class Recommendation {
    String productId1;
    String productId2;
    int nbrOccurrences;

    public Recommendation(String productId1, String productId2) {
        super();
        this.productId1 = productId1;
        this.productId2 = productId2;
        this.nbrOccurrences = 1;
        ;
    }

    public void setNbrOccurrences(int nbrOccurrences) {
        this.nbrOccurrences += nbrOccurrences;
    }
    public int getNbrOccurrences() {
        return nbrOccurrences;
    }
    public boolean compareTo(Recommendation r) {

        return (this.productId1 == r.productId1 && this.productId2==r.productId2) || (this.productId1 == r.productId2 && this.productId2==r.productId1) ;
     }
    public String getProductId1() {
        return productId1;
    }
    public String getProductId2() {
        return productId2;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.productId1+","+this.productId2+","+this.nbrOccurrences;
    }
}
