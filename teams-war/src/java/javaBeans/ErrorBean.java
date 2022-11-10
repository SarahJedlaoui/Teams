package javaBeans;
public class ErrorBean {
    public ErrorBean() {}
    private String errormsg;
    
    private boolean error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    public String getErrormsg() {
        return errormsg;
    }
    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
