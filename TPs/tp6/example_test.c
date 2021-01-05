#include <stdio.h>

#define CTEST_MAIN
#define CTEST_SEGFAULT
#define CTEST_COLOR_OK

#include "ctest.h"

// basic test without setup/teardown
CTEST(suite1, test_vide) {
}

// there are many different ASSERT macro's (see ctest.h)
CTEST(suite1, test2) {
    ASSERT_EQUAL(1,2);
}

CTEST(suite2, test1) {
    ASSERT_STR("foo", "bar");
}

CTEST(ctest, test_assert_interval) {
    ASSERT_INTERVAL(10, 20, 15);
    // ASSERT_INTERVAL(1000, 2000, 3000);
}

CTEST(ctest, test_assert_null) {
    ASSERT_NULL(NULL);
    // ASSERT_NULL((void*)0xdeadbeef);
}

int main(int argc, const char *argv[])
{
    int result = ctest_main(argc, argv);
    return result;
}
