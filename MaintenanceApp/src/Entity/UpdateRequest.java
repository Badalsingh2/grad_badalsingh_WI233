package Entity;

public class UpdateRequest {
    private int requestId;
    private String ownerId;
    private int siteId;
    private String requestedChange;
    private String requestDate;
    private String status; // PENDING / APPROVED / REJECTED

    public UpdateRequest() {}

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getRequestedChange() {
        return requestedChange;
    }

    public void setRequestedChange(String requestedChange) {
        this.requestedChange = requestedChange;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
