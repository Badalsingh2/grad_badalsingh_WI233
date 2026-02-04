package Entity;

public class SiteOwner {
    private String ownerId;
    private String ownerName;


    private long phoneNumber;
    private String email;
    private int siteNumber;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public SiteOwner() {}

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteId) {
        this.siteNumber = siteId;
    }

//    public void setSiteNumber(Integer integer) {
//    }
}
