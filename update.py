# this file is not part of the template
# it's just a script to update this repo when the template is updated

import subprocess

if __name__ == "__main__":
    for command in [
        ["uvx", "copier", "update", "--vcs-ref", "v2", "--skip-answered"],
        ["uv", "sync"],
        ["git", "add", "."],
        ["git", "commit", "-m", "Update template"],
        ["git", "push"],
    ]:
        subprocess.run(command, shell=True, check=True)
