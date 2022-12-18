#include "class_parser.hpp"
#include <fstream>

#define DEFAULT_TEST "Annotations.class"

int main(int argc, char *argv[]) 
{
    const char *test = DEFAULT_TEST;
    if (argc == 2) {
        test = argv[1];
    }
    std::wcout.imbue(std::locale(""));
	std::ifstream f(test, std::ios::binary);
	if(!f.is_open()) {
		std::cout << "Fatal: no " << test << " found in the current directory!" << std::endl;
		return -1;
 	}
	
	ClassFile cf;
	f >> cf;	
}
