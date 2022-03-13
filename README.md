# APCourseMaterials
This repository contains the materials and links for the Advanced Programming (M.Sc) course in java, given on Winter 2021 at Amirkabir University of Technology. I was in the teaching assistance team for this course

## Assignments

- **PhoneBook**
    - *[problem descrption](/PhoneBook/description.md)*
    - *[example solution](/PhoneBook/solution/Main.java)*
    - *[tests](/PhoneBook/tests/)*: written in quera text testing format [^1]

- **Binary Search**

    - *[problem descrption](/BinarySearch/description.md)*
    - *[example solution](/BinarySearch/solution/Main.java)*
    - *[tests](/BinarySearch/tests/)*: written in quera text testing format [^1]


- **Restaurant Orders**

    - *[problem descrption](/RestaurantOrders/description.md)*
    - *[example solution](/RestaurantOrders/restaurant/)*
    - *tests*: This problem lacks test cases. Please contribute to this repository and add [JUNIT 5](https://github.com/junit-team/junit5) tests to [this folder](/RestaurantOrders/restaurant/test/)


- **Computational Load Balancing**
    - *[problem descrption](/BalanceComputationalLoad/description.md)*
    - *[example solution](/BalanceComputationalLoad/src/main/)*
    - *[tests](/BalanceComputationalLoad/src/test/)*

    [BalanceComputationalLoad](/BalanceComputationalLoad/) folder is a gitlab repository containing correct solution, tests , gitlab-ci and gradle configs needed to test and run the code.


[^1]: [quera.ir's](https://quera.ir) text testing format contains an `in` and an `out` folder, prompts `in/input1.txt` as `stdin` to the program. and expects the output written to `stdout` to be exactly like `out/output1.txt`. 
and `out/output2.txt` belongs to `in/input2.txt` and so on. you can implement a *c++* program named `tester.cpp` in order to override the comparison of the submissions output with the correct one. you can see an example of `tester.cpp` [here](./Phonebook/tests/tester.cpp)
</sup>