class Sorting{
    int data [];
    
    Sorting(int []a){
        this.data = a;
    }
    
    public String toString(){
        String output="";
        for(int d:data) output+=" "+d;
        return output;
    }
    //buble sort
    void bubleSort(){
        for(int s=this.data.length-2;s>=0;s--){
            for(int p=0;p<=s;p++){
                if(this.data[p+1]<this.data[p]){
                    //swap
                    int temp = this.data[p+1];
                    this.data[p+1] = this.data[p];
                    this.data[p] =temp;
                }
            }
        }
    }
    
    //selection sort
    void selectionSort(){
        for (int p=0; p<this.data.length-1;p++){
            int min=Integer.MAX_VALUE;
            int minIdx=p+1;
            
            for(int i=p+1;i<this.data.length;i++){
                if(this.data[i] < min) {
                    min= this.data[i];
                    minIdx=i;
                }
            }
            
            if (min<this.data[p]){
                //swap
                int t=this.data[p];
                this.data[p] = min;
                this.data[minIdx] = t;
            }
            
        }
    }
    
    //insertion sort
    void insertionSort(){
        for(int p=1;p<this.data.length;p++){
            int temp = this.data[p];
            boolean stop = false;
            for(int i=p-1;i>=0 && !stop;i--){
                if(this.data[i]>temp){
                    this.data[i+1] = this.data[i];
                    this.data[i] = temp;
                } else{
                    stop =true;
                }
            }
        }
    }
    
    //penjelasan:
    // Merge Sort mengurutkan array secara ascending dengan membagi array menjadi bagian kecil, lalu menggabungkannya kembali secara terurut.
    void mergeSort(){
        split(this.data, 0, this.data.length - 1);
    }
    
    // Split the array into two subarrays, sort them and merge them
    void split(int arr[], int l, int r) {
    if (l < r) {

      // m is the point where the array is divided into two subarrays
      int m = (l + r) / 2;

      split(arr, l, m);
      split(arr, m + 1, r);

      // Merge the sorted subarrays
      merge(arr, l, m, r);
    }
  }
  
  // Merge two subarrays L and M into arr
  void merge(int arr[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = arr[q + 1 + j];

    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = M[j];
        j++;
      }
      k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = M[j];
      j++;
      k++;
    }
  }
  
    //penejelasan:
    // Reverse membalik urutan elemen array dengan memindahkan elemen dari indeks terakhir ke indeks pertama sehingga urutannya menjadi descending.
    void reverse(){
        int r [] = new int[this.data.length];
        int l = this.data.length-1;

        for(int i=0; i<this.data.length; i++){
            r[i] = this.data[l-i];
        }

        this.data = r;
    }
    
    int linearSearch(int k){
       return linearSearch(k,0);
        
    }
    
    //penjelasan:
    // Linear Search rekursif mencari elemen satu per satu dari indeks awal hingga akhir array, mengembalikan indeks jika ditemukan dan -1 jika tidak ditemukan.
    int linearSearch(int k, int i){
        //base case
        if(i == this.data.length){
             return -1;
        }
        //recursive step
        else if(this.data[i]==k){
            return i;
        }
        else{
            return linearSearch(k, i+1);
        }
        
    }
    
    int binarySearch(int k){
        return binarySearch(k, 0, this.data.length-1);
    }
    
    //penjelasan:
    // Binary Search rekursif mencari elemen pada array terurut dengan membandingkan elemen tengah, kemudian melanjutkan pencarian ke bagian kiri atau kanan. Jika batas pencarian terlampaui, method mengembalikan -1.
    int binarySearch(int k, int l, int h){
        //base case
        if(l>h) return -1;
        
        //recursive step
        else{
            int m = (l+h)/2;
            int v = this.data[m];
            
            if(v == k){
                return m;
            }
            else if(v < k){
                return binarySearch(k, m+1, h);
            }
            else{
                return binarySearch(k, l, m-1);
            }
        }
    }
}