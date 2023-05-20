from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque([0 for _ in range(bridge_length)])
    trucks = deque(truck_weights)
    # 매번 다리위의 트럭무게를 구하기 위해 sum function 사용 시 시간 초과 발생.
    sum_ = 0 # 다리 위의 총 트럭 무게 합
    while True:
        exiting_truck = bridge.popleft()
        sum_ -= exiting_truck # 현재 다리위의 총 트럭무게 - 나간 트럭무게
        answer += 1
        if len(bridge) == 0: # 전부 건너면 break
            return answer
        if trucks: # 건너야 할 트럭이 남아있을 때
            if sum_ + trucks[0] <= weight: # 무게 제한을 넘지 않는 경우
                entering_truck = trucks.popleft()
                bridge.append(entering_truck) # 트럭이 이동
                sum_ += entering_truck # 현재 다리위의 총 트럭무게 + 다리에 올라온 트럭무게
            else: # 무게 제한을 넘을 경우
                bridge.append(0)