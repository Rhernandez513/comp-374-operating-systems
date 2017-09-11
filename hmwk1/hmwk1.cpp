#include <iostream>

int main(int argc, char * argv []) {

  if (argc >= 2) {

    /* std::cout << "three" << std::endl; */
    /* std::cout << argv[0] << std::endl; */
    /* std::cout << argv[1] << std::endl; */
    /* std::cout << argv[2] << std::endl; */

    int buffer_size = 0;
    std::string file_name;

    std::string value (argv[1]);
    std::string constant ("--buffer_size");

    if (constant.compare(value) == 0) {
      /* std::cout << value << " should be " << constant << std::endl; */
      buffer_size = std::stoi(argv[2]);
    } else {
      std::cout << value << " is not " << constant << std::endl;
    }

    std::cout << "buffer_size: " << buffer_size << std::endl;

    value = argv[3];
    constant = "--file_name";

    if (constant.compare(value) == 0) {
      /* std::cout << value << " should be " << constant << std::endl; */
      file_name = std::string(argv[4]);
      std::cout << "file_name: "  << file_name << std::endl;
    }

    value =  argv[5];
    constant = "--write_count=";
    std::string prefix (constant);
    std::string arguement (value);

    int write_count;

    if(arguement.substr(0, prefix.size()) == prefix) {
      std::string argumentValue = arguement.substr(prefix.size());
      write_count = std::stoi(argumentValue);
    }

    std::cout << "write_count : " << write_count << std::endl;

  }
  return 0;
}
