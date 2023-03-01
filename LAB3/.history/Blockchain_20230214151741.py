# pre hash
# curr hash
# timestamp
from hashlib import sha256
MAX_NONCE = 100000000000

# SHA256 is a hashing algorithm that takes in a string and returns a hash value


def SHA256(text):
    return sha256(text.encode("ascii")).hexdigest()

# This function will return the hash of the block


def mine(text, prefix_zeros):
    prefixStr = '0'*prefix_zeros
    for nonce in range(MAX_NONCE):
        newText = text + str(nonce)
        newHash = SHA256(newText)
        if newHash.startswith(prefixStr):
            print(f"Successfully Mined! \nnonce value: {nonce}")
            return newHash

    print(f"Couldn't find correct has after trying {MAX_NONCE} times")


if __name__ == '__main__':
    text = "Shubham"
    import time
    startTime = time.time()
    Zeros_leading = 4
    print("Mining started")
    newHash = mine(text, Zeros_leading)
    totalTime = time.time() - startTime
    print(f"Mining computing Time: {totalTime} seconds")
    print(f"Computed Hash Value: {newHash}")
