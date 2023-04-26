# pre hash
# curr hash
# timestamp
from hashlib import sha256
MAX_NONCE = 100000000000


def SHA256(text):
    return sha256(text.encode("ascii")).hexdigest()


def mine(text, prefix_zeros):
    prefixStr = '0'*prefix_zeros
    for nonce in range(MAX_NONCE):
        newText = text + str(nonce)
        newHash = SHA256(newText)
        if newHash.startswith(prefixStr):
            print(f"Successfully mined with nonce value:{nonce}")
            return newHash

    print(f"Couldn't find correct has after trying {MAX_NONCE} times")


if __name__ == '__main__':
    text = "Shubham"
    import time
    start = time.time()
    leadingZeros = 7
    print("start mining")
    newHash = mine(text, leadingZeros)
    totalTime = time.time() - start
    print(f"Mining took: {totalTime} seconds")
    print(newHash)
