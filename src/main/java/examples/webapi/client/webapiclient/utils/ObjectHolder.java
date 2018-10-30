package examples.webapi.client.webapiclient.utils;

public class ObjectHolder {
    public static InheritableThreadLocal<Object> local = new InheritableThreadLocal<Object>();
}
