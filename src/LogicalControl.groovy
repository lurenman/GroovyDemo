def x = 4.0
def result
//groovy 中switch可以为任意类型，可以代替 if else语句;
switch (x) {
    case "hello":
        result = "hello"
        break
//[4.0,1, 2, "haha"] 这也会匹配到
    case [1, 2, "haha"]:
        result = "list"
        break
    case 5..10:
        result = "range"
        break
    case Integer:
        result = "Integer"
    case BigDecimal:
        result = "BigDecimal"
        break
    default:
        result = "default"
        break
}
println(result)

def sum = 0
//对范围的循环
for (i in 0..9) {
    sum += i
}
println(sum)
sum = 0
/**
 * 对list集合的循环
 */
for (i in [1, 2, 3, 4, 5, 6]) {
   sum+=i
}
println(sum)
sum=0
/**
 * 对map集合的 循环
 */
for (i in ['lufei':18,'namei':17,suolong:18]){
    sum+=i.value
}
println(sum)
