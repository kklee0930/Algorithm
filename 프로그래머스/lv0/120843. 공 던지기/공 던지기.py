def solution(numbers, k):
    try_number = 1
    throw_index = 0
    while try_number < k:
        try_number += 1
        throw_index += 2
    answer_index = throw_index % len(numbers)
    return numbers[answer_index]