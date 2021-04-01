#include <sys/stat.h>
struct stat getFileStat();
void helloFromNative();
struct MyStruct createMyStruct();
struct MyStruct* createMyStructPointer();


struct MyStruct {
    int availableOnAllPlatforms;
    #if __APPLE__
            #include "TargetConditionals.h"
            #if TARGET_OS_IPHONE && TARGET_IPHONE_SIMULATOR
                int availableOnIphoneSimulator;
                int availableOnIos;
            #elif TARGET_OS_IPHONE
                int availableOnIos;
            #elif TARGET_OS_MAC
                int availableOnMacos;
            #endif
    	#else
    	    int notAvailableOnMacos;
    	#endif
};
