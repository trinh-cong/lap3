const fs = require('fs');
        const path = require('path');

// Paths to the input and output files
        const inputFilePath = path.join(__dirname, 'input.txt');
        const outputFilePath = path.join(__dirname, 'output.txt');

// Read the content from the input file
        const inputText = fs.readFileSync(inputFilePath, 'utf-8');

// Encrypt the text
        const encryptedText = inputText.split('').map(char => {
        // Check if the character is an alphabetic character
        if (/[a-zA-Z]/.test(char)) {
        const code = char.charCodeAt(0);
        // Convert the ASCII code of the character
        let newCode = code + 3;
        if (char.toUpperCase() <= 'W') {
        newCode = newCode - 26;
        }
        // Convert the new ASCII code into a new character
        return String.fromCharCode(newCode);
        } else {
        return char;
        }
        }).join('');

// Write the encrypted content to the output file
        fs.writeFileSync(outputFilePath, encryptedText);