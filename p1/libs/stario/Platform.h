#ifndef platform__
#define platform__

#if (defined(WIN32) || defined(_WIN32_WCE))

#include <Win32.h>

#elif TARGET_OS_IPHONE
    #ifdef BUILDING_STARIO
        #include <Mac.h>
    #else
        #include <Mac.h>
    #endif

#elif defined(__APPLE__)

#include <Mac.h>

#else

#include <Linux.h>

#endif

#endif

