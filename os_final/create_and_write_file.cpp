#include <iostream>
#include <fstream>

int main() {
  std::cout << "This binary creates a file, watch out for \"Write_Out_Contents.txt\"" << std::endl;
  std::ofstream file_handle;
  file_handle.open("Write_Out_Contents.txt");
  file_handle << "Hello Prof Kaylor!\n";
  file_handle.close();
  return 0;
}

// EOF
