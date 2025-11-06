# Define Huffman Tree Node class
class Node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq
        self.symbol = symbol
        self.left = left
        self.right = right
        self.huff = ''

# Function to build Huffman Tree (without heapq)
def build_huffman_tree(symbols, frequencies):
    nodes = [Node(frequencies[i], symbols[i]) for i in range(len(symbols))]

    # Build until one node remains
    while len(nodes) > 1:
        # Sort by frequency (smallest first)
        nodes = sorted(nodes, key=lambda x: x.freq)

        # Pick two smallest
        left = nodes.pop(0)
        right = nodes.pop(0)

        left.huff = 0
        right.huff = 1

        # Create new node combining them
        new_node = Node(left.freq + right.freq, left.symbol + right.symbol, left, right)

        # Add new node back to list
        nodes.append(new_node)

    return nodes[0]  # root node

# Function to print Huffman Codes
def print_codes(node, val=''):
    new_val = val + str(node.huff)
    if node.left:
        print_codes(node.left, new_val)
    if node.right:
        print_codes(node.right, new_val)
    if not node.left and not node.right:
        print(f"{node.symbol} -> {new_val}")

# Main function for user input
def huffman_user_input():
    n = int(input("Enter number of characters: "))
    symbols = []
    frequencies = []

    for i in range(n):
        ch = input(f"Enter character {i+1}: ")
        freq = int(input(f"Enter frequency of '{ch}': "))
        symbols.append(ch)
        frequencies.append(freq)

    root = build_huffman_tree(symbols, frequencies)
    print("\nHuffman Codes:")
    print_codes(root)

# Run program
if __name__ == "__main__":
    huffman_user_input()
