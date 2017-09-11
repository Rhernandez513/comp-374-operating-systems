#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char* argv[]) {
  int SomeValue = 100;
  int pid = fork();
  int fd = open("test_file", O_WRONLY | O_CREAT | O_TRUNC, 0666);

  const char *parentMessage = "11111111";
  const char *childMessage = "2222222222222222222\n";

  if (pid > 0) {
    printf("hello from the parent process, child pid = %d\n", pid);
    sleep(2);
    printf("parent's SomeValue = %d\n", SomeValue);
    write(fd, parentMessage, strlen(parentMessage) * sizeof(char));
  } else if (pid == 0) {
    printf("Hello from the child process\n");
    SomeValue = 200;
    printf("Child's SomeValue = %d\n", SomeValue);
    write(fd, childMessage, strlen(childMessage) * sizeof(char));
  } else {
    printf("fork() failed!! \n");
  }

  close(fd);

//  getchar();
  return 0;
}
