import pkg.print
import pkg.printFile
import platform.posix.fclose
import platform.posix.fopen

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        fopen(args.first(), "r")?.let { file ->
            printFile(file)
            fclose(file)
        }
    }

    print()
}
