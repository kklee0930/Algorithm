def solution(numbers, direction):
    if direction == 'right':
        numbers.insert(0, numbers.pop())
        return numbers
    else:
        elem = numbers[0]
        numbers.append(numbers[0])
        numbers.remove(numbers[0])
        return numbers