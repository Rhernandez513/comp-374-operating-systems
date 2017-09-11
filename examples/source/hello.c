#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char* argv[]) {

  int pid = fork();

  if (pid > 0) {
    printf("hello from the parent process, child pid = %d \n", pid);
  } else if (pid == 0) {
    printf("Hello from the child process\n");
  } else {
    printf("fork() failed!! \n");
  }

  printf("Hello World\n");
//  getchar();
  return 0;
}
