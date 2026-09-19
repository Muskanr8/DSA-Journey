bool isPalindrome(int x) {
    int temp;
    long rev = 0;
    temp = x;

    while (x > 0) {
        rev = rev * 10 + x % 10;
        x /= 10;
    }


    if(temp == rev){
        return true;
    } else{
        return false;
    }
}
