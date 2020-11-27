Problem 1
        # String1='CAAABBBC'
        # String2='AAABBBCC'
        ## Can Do Two Operation Either Insertion or deletion tell for minimum git diff operations you can convert one string to another

        get_min_diff_required(str1, str2){
        Int total_num_operations_performed = 0
        If (len(str1) > len(str2))
        Max_str = str1
        Min_str = str2
        Else{
        Max_str = str2   // 'AAABBBCC'
        Min_str = str1     // 'AAABBBCC'
        }
        If len(Max_str) == 0){
        Return 0
        }
        If (len(min_str) == 0){
        Return len(max_str)
        }
        Int max_str_index = 0
        For (i = 0; i < len(min_str); i ++){  //i = 8
        If( Max_str[i] != min_str[i]){
        Total_num_operations_performed += 1}
        }

        Total_num_operations_performed += (len(max_str) - len(min_str))


        Return total_num_operations_performed  // return 3
        }

        Problem 2
        # array=['9','02','90','12901201']


        get_max_number_formed(array_input){


        }
        990
        90

        Int compare(str1, str2){
        Result = “”
        if(len(str1) < len(str2)
        Min_str = str1
        Max_str = str2
        Else
        Min_str = str2
        Max_str = str1

        for(i=0; i < len(Max_str) - len(Min_str); i++){
        for(j=i; j< len(Min_str); j++){

        if((int)Min_str[i] < (int)Max_str[i]){  // 90 and 990
        Result = Max_str //990
        break
        }
        }

        if(result == “”)

        }
