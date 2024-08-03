## Changing File Permissions

Command:
```sh
ansible all -i inventory.ini -m user -a "name=sammy state=present" --become
ansible all -i inventory.ini -m group -a "name=sammy state=present" --become
ansible all -i inventory.ini -m file -a "dest=/home/ec2-user/myfile.txt mode=600 owner=sammy group=sammy" --become 
```
### Exercise:

1. Change the permissions and ownership of a file on the remote nodes. Use the --become option if necessary.


