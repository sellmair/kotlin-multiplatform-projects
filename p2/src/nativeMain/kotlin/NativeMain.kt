import platform.posix.stat
import platform.posix.fopen

fun main() {
    fopen("juhu.txt", "rw")
    withPosix.helloFromNative()
    //getFileStat().useContents { score(this) } // TODO: Why was that not further commonized :(
}

expect fun score(stat: stat): Int
