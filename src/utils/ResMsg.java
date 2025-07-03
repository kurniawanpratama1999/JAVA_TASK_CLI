package utils;

public class ResMsg<T> {
    private final boolean success;
    private final String msg;
    private final  T data;

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public ResMsg(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResMsg<T> ok (String msg, T data){
        return new ResMsg<>(true, msg, data);
    }

    public static <T> ResMsg<T> fail (String msg){
        return new ResMsg<>(false, msg, null);
    }

    public static <T> ResMsg<T> err (String msg){
        return new ResMsg<>(false, "err: " + msg, null);
    }
}
