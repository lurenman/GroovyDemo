//文件操作

def file = new File('../GroovyDemo.iml')
//1返回文件中的内容输出每行的操作
//file.eachLine {
//    line->
//        println(line)
//}
//2返回文件中的内容
//def filetext = file.getText()
//println(filetext)
//这个是把它们装到一个list里
//def lines = file.readLines()
//println(lines)
//获取到文件中的指定字符内容，和java一样
def readerContent = file.withReader {
    read ->
        def buffer = new char[100]
        read.read(buffer)
        return buffer
}
//println(readerContent)
//def writer = file.withWriter {}

//下面实现文件拷贝操作

def copy(String srcPath, String desPath) {
    try {
        def desfile = new File(desPath)
        //如果目标文件不存在就创建
        if (!desfile.exists()) {
            desfile.createNewFile()
        }
        def srcfile = new File(srcPath)
        if (!srcfile.exists()) {
            throw RuntimeException("源文件不存在")
        }
        //获取文件内容
        def srctext = srcfile.getText()
        desfile.withWriter {
            writer ->
                writer.append(srctext)
        }
        //另一种通过每行去写入
//        new File(sourcePath).withReader { reader ->
//            def lines = reader.readLines()
//            desFile.withWriter { writer ->
//                lines.each { line ->
//                    writer.append(line + "\r\n")
//                }
//            }
//        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }//流关闭groovy已经实现了看源码
    return false
}

//def b = copy("../GroovyDemo.iml", "../CopyFile.iml")
//println(b)

//下面开始做存储对象到文件的操作

/*def saveObjectToFile(Object obj, String desPath) {
    try {
        def desfile = new File(desPath)
        //如果目标文件不存在就创建
        if (!desfile.exists()) {
            desfile.createNewFile()
        }
        desfile.withObjectOutputStream {
            out ->
                out.writeObject(obj)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}
//对象必须序列化，说白了就是操作序列化
def stu = new object.Student(name:"namei",age: 20)
println(saveObjectToFile(stu,"../StudentFile.iml"))*/

//开始读取对象，反序列化
def readObject(String path) {
    Object obj = null
    try {
        def file = new File(path)
        if (!file.exists()) {
            return null
        }
        file.withObjectInputStream {
            input ->
                obj = input.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}
def stuObject = readObject("../StudentFile.iml") as object.Student
if (stuObject!=null){
    println("name: ${stuObject.name} age:${stuObject.age}")
}else {
    println("读取对象失败")
}


