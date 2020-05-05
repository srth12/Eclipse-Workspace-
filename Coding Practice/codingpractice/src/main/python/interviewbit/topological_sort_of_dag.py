# https://www.geeksforgeeks.org/python-program-for-topological-sorting/
from collections import defaultdict

def get_topological_sorted_vnfs():
    '''
    '''
    vnfrs = ['a', 'b','c', 'd']
    dependencies = {'a': ['b', 'c'], 'b':['c']}
    if len(dependencies) == 0:
        return vnfrs
    vnf_list = []
    visited = defaultdict(bool)
    for vnfr in vnfrs:
        if vnfr not in dependencies:
            vnf_list.append(vnfr)
            visited[vnfr] = True
        elif len(dependencies[vnfr]) == 0:
            vnf_list.append(vnfr)
            del dependencies[vnfr]
            visited[vnfr] = True
    for dependent_vnf, dependee_vnf_list in dependencies.items():
        if not visited[dependent_vnf]:
            get_topological_sorted_vnf_util(dependent_vnf, visited, dependencies, vnf_list)
    return vnf_list


def get_topological_sorted_vnf_util(dependent_vnf, visited, dependencies, vnf_list):
    '''
    '''
    for dependee_vnf in dependencies[dependent_vnf]:
        if not visited[dependee_vnf]:
            get_topological_sorted_vnf_util(dependee_vnf, visited, dependencies, vnf_list)
    visited[dependent_vnf] = True
    vnf_list.append(dependent_vnf)

if __name__ == "__main__":
    vnf_list= get_topological_sorted_vnfs()
    print(vnf_list)