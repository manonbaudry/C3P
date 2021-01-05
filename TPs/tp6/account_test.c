#include <stdio.h>

#define CTEST_MAIN
#define CTEST_SEGFAULT
#define CTEST_COLOR_OK

#include "ctest.h"
#include "account.h"

CTEST(suite_account, test_account_creation) {
    account account;
    init_account(&account, "toto");
    ASSERT_EQUAL(0, account.id);
    ASSERT_STR("toto", account.name);
    ASSERT_EQUAL(0, account.amount);
    free_account(&account);
}

int main(int argc, const char *argv[])
{
    int result = ctest_main(argc, argv);
    return result;
}