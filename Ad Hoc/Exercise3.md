## Defining Targets for Command Execution
Command:
```sh
ansible webservers -i inventory.ini -m ping
ansible server1:db -i inventory.ini -m ping
```
### Exercise:

1. Define and execute commands targeting specific groups or hosts. Experiment with excluding certain hosts and targeting hosts belonging to multiple groups.

