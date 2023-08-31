import hashlib
import base64

code_verifier = "your_random_code_verifier"
code_verifier_hash = hashlib.sha256(code_verifier.encode()).digest()
code_challenge = base64.urlsafe_b64encode(code_verifier_hash).rstrip(b'=').decode()

print("code_challenge:", code_challenge)