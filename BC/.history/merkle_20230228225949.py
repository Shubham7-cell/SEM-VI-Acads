from pymerkle import *

tree = MerkleTree()

transactions = [b'Noman->100->Varun',b'Noman->100->Shubham',b'Shubham->100->Varun',b'Shubham->100->Noman',b'Varun->100->Shubham',b'Varun->100->Noman',b'Zedx->100->Suyog',b'Zedx->100->Suyog',b'Zedx->100->Suyog101',b'Hiba->100->Suyog102']

# Populate tree with some entries
for data in transactions:
    tree.append_entry(data)

# Prove and verify inclusion of `bar`
challenge = b'485904129bdda5d1b5fbc6bc4a82959ecfb9042db44dc08fe87e360b0a3f2501'
proof = tree.prove_inclusion(challenge)
proof.verify()

# Save current tree state
state = tree.get_root()

# Append further leaves
for data in [b'Noman->100->Varun',b'Noman->100->Shubham',b'Varun->100->Shubham',b'Suyog->100->Shubham']:
    tree.append_entry(data)

# Prove and verify saved state
proof = tree.prove_consistency(challenge=state)
proof.verify()
