class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        # identify row
        first, last = 0, m - 1
        rowToSearch = -1
        while first <= last:
            mid = (first + last) // 2
            if matrix[mid][0] <= target and target <= matrix[mid][-1]:
                rowToSearch = mid
                break
            elif target < matrix[mid][0]:
                last = mid -1
            else:
                first = mid + 1
        
        # find in row
        print(rowToSearch)
        left, right = 0, n - 1

        while left <= right:
            mid = (left + right)//2
            if matrix[rowToSearch][mid] == target:
                return True
            elif target < matrix[rowToSearch][mid]:
                right = mid -1
            else:
                left = mid +1
        return False