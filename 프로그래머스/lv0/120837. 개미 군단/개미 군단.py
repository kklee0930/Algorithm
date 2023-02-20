def solution(hp):  
    general = hp // 5
    hp -= general * 5
    soldier = hp // 3
    hp -= soldier * 3
    worker = hp // 1
    return general + soldier + worker