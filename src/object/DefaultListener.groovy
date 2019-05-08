package object
/**
 * 就是把接口提供了一种默认实现的方式
 */
trait DefaultListener {
    //不是抽象的还必须{}括起来  //这种都是默认实现
    void eat(){

    }
    //只有定义成abstract 的才会必须实现
    abstract void drink()
   //这种都是默认实现
    void play() {
        println("play")
    }
}