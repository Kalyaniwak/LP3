import time

# QuickSort with deterministic pivot (last element as pivot)
def quick_sort_deterministic(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[-1]  # Last element as pivot
    left = [x for x in arr[:-1] if x <= pivot]
    right = [x for x in arr[:-1] if x > pivot]
    return quick_sort_deterministic(left) + [pivot] + quick_sort_deterministic(right)

# QuickSort with randomized pivot
def quick_sort_randomized(arr):
    import random
    if len(arr) <= 1:
        return arr
    pivot = arr[random.randint(0, len(arr) - 1)]  # Random element as pivot
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quick_sort_randomized(left) + middle + quick_sort_randomized(right)

# Function to perform sorting and compare times
def analyze_sorting():
    # Take user input for array
    arr = list(map(int, input("Enter elements separated by space: ").split()))
    print("Original array:", arr)

    # Deterministic QuickSort
    start = time.time()
    sorted_arr_deterministic = quick_sort_deterministic(arr.copy())
    end = time.time()
    time_deterministic = end - start
    print("\nDeterministic QuickSort result:", sorted_arr_deterministic)
    print(f"Time taken by Deterministic QuickSort: {time_deterministic:.6f} seconds")

    # Randomized QuickSort
    start = time.time()
    sorted_arr_randomized = quick_sort_randomized(arr.copy())
    end = time.time()
    time_randomized = end - start
    print("\nRandomized QuickSort result:", sorted_arr_randomized)
    print(f"Time taken by Randomized QuickSort: {time_randomized:.6f} seconds")

# Run the analysis
analyze_sorting()
