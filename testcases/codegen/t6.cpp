/*
Test Package: Codegen
Author: Admin
Time: 2020-01-25
Input:
=== input ===
=== end ===
Output:
=== output ===
=== end ===
ExitCode: 16
InstLimit: -1
Origin Package: Codegen Pretest-529
*/

int main() {
    int a = 5;
    int b;
    int c;
    c = a++;
    b = c;
    return a;
}