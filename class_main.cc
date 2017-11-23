#include "class_parser.hpp"
#include <fstream>


int main(int argc, char *argv[]) 
{
	std::wcout.imbue(std::locale(""));
	std::ifstream f("Annotations.class", std::ios::binary);
	if(!f.is_open()) {
		std::cout << "wrong!" << std::endl;
		return -1;
 	}
	
	ClassFile cf;
	f >> cf;	
}
