package utils;

public class ResMsg<T> {
    boolean success;
    String msg;
    T data;

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
