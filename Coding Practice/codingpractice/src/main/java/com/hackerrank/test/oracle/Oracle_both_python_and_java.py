2 7 3 1 8 4 9

7 8 9

6 4 1

import PriorityQueue

class MaxPriorityQueue(PriorityQueue):

    def __init__(self, element):
        self._element = element

    def __cmp__(self, other):
        if self._element > other:
            return -1
        elif self._element = other:
            return 0
        else:
            return 1


array # Assuming its given
#MaxPriorityQueue()
#for element in array:


array_dict = dict()
idx = 0
for element in array:
    array_dict[element] = idx
    idx += 1


array = sort(array)
ele1 = array[-1]
ele2 = array[-2]
ele3 = array[-3]

print(array_dict[ele1])
print(array_dict[ele2])
print(array_dict[ele3])

===============================

Contact
Name
Phone no
Email

List<Contact> - contains duplicates (Name is same and either phone no or email is same)
remove the duplicates & merge the contacts

1. Sarath
99999999
sarath@gmail.com

2. Sarath
9999999


3. Anil
888888

4. Anil
888888
anil@hgmail.com

class Contact{
private String name;
private String phoneNo;
private String email;
//corresponding gatters/setters

public boolean equals(){
Contact contact = (Contact) obj;
obj2_phone_include_hast = contact.getName(), contact.getPhoneNo()
obj_phone_include_hast = this.hash(this.getName(), this.getPhoneNo())
if ( obj2_phone_include_hast == obj_phone_include_hast)
return true;

obj2_email_include_hast = this.hash(contact.getName(), contact.getEmail())
obj_email_include_hast = this.hash(contact.getName(), contact.getEmail())
if (obj_email_include_hast == obj2_email_include_hast)
    return true;

return false;
}

public int hash(Object obj){
Contact contact = (Contact) obj;
return this.name == contact.getName()

}
}


Set<Contact> contactSet = HashSet<>();

