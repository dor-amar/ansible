## Copying Files

Command:
```sh
ansible all -i inventory.ini -m copy -a "src=./example.txt dest=~/myfile.txt"
ansible all -i inventory.ini -m copy -a "src=~/example.txt remote_src=yes dest=./file.txt"
```
### Exercise:

1. Copy a file from the control node to the managed nodes and vice versa. Experiment with different source and destination paths.

