package object

class Student implements OnClickListener, DefaultListener {
    String name
    Integer age

    def foo(String str) {
        println(str)
    }

    @Override
    void onclick() {

    }

    @Override
    void drink() {

    }
    /**
     * 这个先拦截到
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name,Object args){
        println("Missing the method is ${name} the params is ${args}")
    }
/**
 * 一个方法找不到的时候会判断
 * @param s
 * @param o
 * @return
 */
    @Override
    Object invokeMethod(String s, Object o) {
        // return super.invokeMethod(s, o)
        println("invoke the method is ${s} the params is ${o}")
    }

    /**
     * methodMissing->invokeMethod
     */

}
