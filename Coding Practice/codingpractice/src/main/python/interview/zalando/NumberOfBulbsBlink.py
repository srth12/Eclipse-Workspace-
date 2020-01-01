# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# _bulb_on_tracker = []
idx_til_seq_bulb = 0

def update_idx_til_seq_bulb(bulb_positon, idx_til_seq_bulb, _bulb_on_tracker):
    while True:
        if len(_bulb_on_tracker) >= idx_til_seq_bulb and _bulb_on_tracker[idx_til_seq_bulb] != 0:
            idx_til_seq_bulb += 1
        else:
            break
    return idx_til_seq_bulb

def solution(A):
    # write your code in Python 3.6
    idx_til_seq_bulb = 0
    no_of_shines = 0
    _bulb_on_tracker = [0] * len(A)

    for idx, bulb_positon in enumerate(A):
        if idx_til_seq_bulb + 1 == bulb_positon:
            no_of_shines += 1
            _bulb_on_tracker[bulb_positon - 1] = bulb_positon
            idx_til_seq_bulb += 1
            idx_til_seq_bulb = update_idx_til_seq_bulb(bulb_positon, idx_til_seq_bulb, _bulb_on_tracker)
        else:
            _bulb_on_tracker[bulb_positon - 1] = bulb_positon

    return no_of_shines

if __name__ == '__main__':
    S = [2, 1, 3, 5, 4]
    # print(S[-1])
    k = solution(S)
    print(k)
