#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main(int argc, char const *argv[])
{
 
	ifstream test_in(argv[1]);    /* This stream reads from test's input file   */
	ifstream test_out(argv[2]);   /* This stream reads from test's output file  */
	ifstream user_out(argv[3]);   /* This stream reads from user's output file  */
 
	/* Your code here */
	/* If user's output is correct, return 0, otherwise return 1       */
	string out_line,user_line;
	int i=0;
	while(getline(test_out,out_line)){
		i++;
		if(getline(user_out,user_line)){
			if(out_line.rfind("id:",0) != 0){
				if(out_line != user_line){
					cout << "line " << i << "isn't equal."<< endl;
					return 1;
				}
			}
		}else{
			cout << "user out ended."<< endl;
			return 1;
		}
	}
    return 0;
}