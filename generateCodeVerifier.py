import secrets

code_verifier = secrets.token_urlsafe(64)
print("Generated code_verifier:", code_verifier)