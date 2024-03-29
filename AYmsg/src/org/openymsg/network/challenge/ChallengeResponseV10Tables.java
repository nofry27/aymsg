/*
 * OpenYMSG, an implementation of the Yahoo Instant Messaging and Chat protocol.
 * Copyright (C) 2007 G. der Kinderen, Nimbuzz.com 
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA. 
 */
package org.openymsg.network.challenge;

/**
 * Tables for the post January 2004 Yahoo auth routines in ChallengeResponseV10 .
 * 
 * @author G. der Kinderen, Nimbuzz B.V. guus@nimbuzz.com
 * @author S.E. Morris
 */
public interface ChallengeResponseV10Tables {
	// Offsets of various tables in binary data (should be either 256 or 32
	// bytes each).
	public static final char[] TABLE_OFFSETS = {
			0,
			256,
			512,
			544,
			800,
			832,
			1088,
			1120,
			1376,
			1408, // Tables 0 - 9 (1408)
			1664,
			1696,
			1952,
			1984,
			2240,
			2272,
			2528,
			2784,
			3040,
			3296, // Tables 10 - 19 (1888)
			3552,
			3584,
			3840,
			3872,
			4128,
			4384,
			4416,
			4448,
			4704,
			4736, // Tables 20 - 29 (1440)
			4992,
			5024,
			5280,
			5536,
			5792,
			6048,
			6304,
			6560,
			6816,
			7072, // Tables 30 - 39 (2336)
			7104,
			7136,
			7168,
			7200,
			7456,
			7488,
			7744,
			8000,
			8032,
			8064, // Tables 40 - 49 (992)
			8096,
			8128,
			8160,
			8416,
			8672,
			8704,
			8736,
			8992,
			9248,
			9504, // Tables 50 - 59 (1440)
			9760,
			9792,
			10048,
			10304,
			10560,
			10592,
			10624,
			10656,
			10912,
			11168, // Tables 60 - 69 (1664)
			11424,
			11680,
			11712,
			11968,
			12224,
			12480,
			12736,
			12992,
			13024,
			13056, // Tables 70 - 79 (1888)
			13088,
			13344,
			13376,
			13632,
			13664,
			13696,
			13952,
			13984,
			14016,
			14048, // Tables 80 - 89 (992)
			14080,
			14336,
			14368,
			14400,
			14656,
			14688,
			14720,
			14976,
			15232,
			15488, // Tables 90 - 99 (1440)
			15520, 15776,
			15808,
			15840,
			15872,
			16128,
			16384,
			16416,
			16448,
			16704, // Tables 100 - 109 (1216)
			16960, 17216, 17248,
			17504,
			17760,
			17792,
			18048,
			18080,
			18336,
			18592, // Tables 110 - 119 (1888)
			18624, 18880, 18912, 19168,
			19424,
			19680,
			19712,
			19744,
			20000,
			20032, // Tables 120 - 129 (1440)
			20288, 20320, 20352, 20608, 20864,
			20896,
			21152,
			21408,
			21440,
			21472, // Tables 130 - 139 (1440)
			21504, 21536, 21792, 22048, 22080, 22112,
			22368,
			22624,
			22656,
			22912, // Tables 140 - 149 (1440)
			22944, 23200, 23456, 23488, 23520, 23776, 24032,
			24288,
			24320,
			24576, // Tables 150 - 159 (1664)
			24832, 25088, 25344, 25600, 25632, 25664, 25920, 26176,
			26432,
			26688, // Tables 160 - 169 (2112)
			26944, 27200, 27232, 27264, 27296, 27328, 27360, 27392, 27648,
			27904, // Tables 170 - 179 (1216)
			28160, 28416, 28672, 28928, 28960, 28992, 29248, 29504, // Tables
			// 180 - 187
			// (1632)
			29536 // Length of file
	};

	// Defines for constants in table below
	public final static int IDENT = 1;

	public final static int XOR = 2;

	public final static int MULADD = 3;

	public final static int LOOKUP = 4;

	public final static int BITFLD = 5;

	// Const names for three entries in inner array of table below
	public final static int OP = 0;

	public final static int ARG1 = 1;

	public final static int ARG2 = 2;

	/**
	 * Five tables, each with 96 entries, each entry of three ints [5][96][3]
	 * ... However, because Java supports non-rectangular arrays we don't have
	 * to include all three entries for ops which use only one argument -
	 * reducing class size.
	 */
	public final static int[][][] OPS = {
			{ {} // Table 0
			// All 96 entries in this table are { IDENT,0,0 } ... effect-
			// ively NO-OPs. These have been removed to reduce class size
			// and replaced by a line of code trapping table 0 lookups.
			},
			{
					{ MULADD, 0x36056CD7, 0x4387 }, // Table 1
					{ LOOKUP, 0 }, { LOOKUP, 1 }, { BITFLD, 2 }, { LOOKUP, 3 },
					{ BITFLD, 4 }, { MULADD, 0x4ABB534D, 0x3769 },
					{ XOR, 0x1D242DA5 }, { MULADD, 0x3C23132D, 0x339B },
					{ XOR, 0x0191265C }, { XOR, 0x3DB979DB }, { LOOKUP, 5 },
					{ XOR, 0x1A550E1E }, { XOR, 0x2F140A2D },
					{ MULADD, 0x7C466A4B, 0x29BF }, { XOR, 0x2D3F30D3 },
					{ MULADD, 0x7E823B21, 0x6BB3 }, { BITFLD, 6 },
					{ LOOKUP, 7 }, { BITFLD, 8 }, { LOOKUP, 9 },
					{ BITFLD, 10 }, { LOOKUP, 11 }, { BITFLD, 12 },
					{ LOOKUP, 13 }, { BITFLD, 14 },
					{ MULADD, 0x5B756AB9, 0x7E9B }, { LOOKUP, 15 },
					{ XOR, 0x1D1C4911 }, { LOOKUP, 16 }, { LOOKUP, 17 },
					{ XOR, 0x46BD7771 }, { XOR, 0x51AE2B42 },
					{ MULADD, 0x2417591B, 0x177B },
					{ MULADD, 0x57F27C5F, 0x2433 }, { LOOKUP, 18 },
					{ LOOKUP, 19 }, { XOR, 0x71422261 }, { BITFLD, 20 },
					{ MULADD, 0x58E937F9, 0x1075 }, { LOOKUP, 21 },
					{ BITFLD, 22 }, { LOOKUP, 23 }, { LOOKUP, 24 },
					{ MULADD, 0x0B4C3D13, 0x1597 }, { BITFLD, 25 },
					{ XOR, 0x0FE07D38 }, { MULADD, 0x689B4017, 0x3CFB },
					{ BITFLD, 26 }, { LOOKUP, 27 }, { XOR, 0x35413DF3 },
					{ MULADD, 0x05B611AB, 0x570B },
					{ MULADD, 0x0DA5334F, 0x3AC7 }, { XOR, 0x47706008 },
					{ BITFLD, 28 }, { LOOKUP, 29 }, { BITFLD, 30 },
					{ XOR, 0x57611B36 }, { MULADD, 0x314C2CD1, 0x2B5B },
					{ XOR, 0x1EF33946 }, { MULADD, 0x28EA041F, 0x638F },
					{ LOOKUP, 31 }, { LOOKUP, 32 }, { LOOKUP, 33 },
					{ MULADD, 0x511537CB, 0x7135 },
					{ MULADD, 0x1CF71007, 0x5E17 }, { XOR, 0x583D4BCF },
					{ LOOKUP, 34 }, { XOR, 0x373E6856 },
					{ MULADD, 0x4D595519, 0x1A7D }, { LOOKUP, 35 },
					{ LOOKUP, 36 }, { XOR, 0x0E2A36A7 }, { LOOKUP, 37 },
					{ LOOKUP, 38 }, { BITFLD, 39 }, { BITFLD, 40 },
					{ XOR, 0x53F3604F }, { BITFLD, 41 }, { BITFLD, 42 },
					{ MULADD, 0x1EDC0BA3, 0x7531 }, { LOOKUP, 43 },
					{ XOR, 0x10DF1038 }, { BITFLD, 44 }, { LOOKUP, 45 },
					{ XOR, 0x4EDE0CAC }, { MULADD, 0x2F076EEB, 0x5BCF },
					{ XOR, 0x6D86030F }, { XOR, 0x3F331713 }, { LOOKUP, 46 },
					{ MULADD, 0x41CD726F, 0x3F79 }, { BITFLD, 47 },
					{ XOR, 0x0ECE0054 }, { MULADD, 0x19B32B03, 0x4AD1 },
					{ BITFLD, 48 }, { BITFLD, 49, 0 } },
			{
					{ MULADD, 0x39731111, 0x419B }, // Table 2
					{ XOR, 0x54F7757A }, { BITFLD, 50 }, { BITFLD, 51 },
					{ LOOKUP, 52 }, { LOOKUP, 53 },
					{ MULADD, 0x3CC0256B, 0x7CE7 }, { XOR, 0x79991847 },
					{ MULADD, 0x228F7FB5, 0x472D },
					{ MULADD, 0x32DA290B, 0x7745 }, { XOR, 0x7A28180D },
					{ BITFLD, 54 }, { BITFLD, 55 },
					{ MULADD, 0x5C814F8B, 0x227F }, { LOOKUP, 56 },
					{ MULADD, 0x0B496F6D, 0x412D }, { XOR, 0x6F4B62DA },
					{ LOOKUP, 57 }, { XOR, 0x64973977 }, { LOOKUP, 58 },
					{ LOOKUP, 59 }, { BITFLD, 60 }, { LOOKUP, 61 },
					{ LOOKUP, 62 }, { XOR, 0x6DD14C92 }, { LOOKUP, 63 },
					{ BITFLD, 64 }, { BITFLD, 65 }, { BITFLD, 66 },
					{ LOOKUP, 67 }, { XOR, 0x5E6324D8 }, { LOOKUP, 68 },
					{ LOOKUP, 69 }, { LOOKUP, 70 }, { BITFLD, 71 },
					{ XOR, 0x62745ED0 }, { MULADD, 0x102C215B, 0x0581 },
					{ LOOKUP, 72 }, { LOOKUP, 73 }, { LOOKUP, 74 },
					{ MULADD, 0x19511111, 0x12C1 }, { LOOKUP, 75 },
					{ MULADD, 0x2A6E2953, 0x6977 }, { LOOKUP, 76 },
					{ XOR, 0x55CD5445 }, { BITFLD, 77 }, { BITFLD, 78 },
					{ MULADD, 0x646C21EB, 0x43E5 }, { XOR, 0x71DC4898 },
					{ XOR, 0x167519CB }, { XOR, 0x6D3158F8 },
					{ XOR, 0x7EA95BEA }, { BITFLD, 79 }, { XOR, 0x47377587 },
					{ XOR, 0x2D8B6E8F }, { MULADD, 0x5E6105DB, 0x1605 },
					{ XOR, 0x65B543C8 }, { LOOKUP, 80 }, { BITFLD, 81 },
					{ MULADD, 0x48AF73CB, 0x0A67 }, { XOR, 0x4FB96154 },
					{ LOOKUP, 82 }, { BITFLD, 83 }, { XOR, 0x622C4954 },
					{ BITFLD, 84 }, { XOR, 0x20D220F3 }, { XOR, 0x361D4F0D },
					{ XOR, 0x2B2000D1 }, { XOR, 0x6FB8593E }, { LOOKUP, 85 },
					{ BITFLD, 86 }, { XOR, 0x2B7F7DFC },
					{ MULADD, 0x5FC41A57, 0x0693 },
					{ MULADD, 0x17154387, 0x2489 }, { BITFLD, 87 },
					{ BITFLD, 88 }, { BITFLD, 89 }, { LOOKUP, 90 },
					{ XOR, 0x7E221470 }, { XOR, 0x7A600061 }, { BITFLD, 91 },
					{ BITFLD, 92 }, { LOOKUP, 93 }, { BITFLD, 94 },
					{ MULADD, 0x00E813A5, 0x2CE5 },
					{ MULADD, 0x3D707E25, 0x3827 },
					{ MULADD, 0x77A53E07, 0x6A5F }, { BITFLD, 95 },
					{ LOOKUP, 96 }, { LOOKUP, 97 }, { XOR, 0x43A73788 },
					{ LOOKUP, 98 }, { BITFLD, 99 }, { LOOKUP, 100 },
					{ XOR, 0x55F4606B }, { BITFLD, 101, 0 } },
			{
					{ BITFLD, 102 }, // Table 3
					{ MULADD, 0x32CA58E3, 0x04F9 }, { XOR, 0x11756B30 },
					{ MULADD, 0x218B2569, 0x5DB1 }, { XOR, 0x77D64B90 },
					{ BITFLD, 103 }, { LOOKUP, 104 },
					{ MULADD, 0x7D1428CB, 0x3D }, { XOR, 0x6F872C49 },
					{ XOR, 0x2E484655 }, { MULADD, 0x1E3349F7, 0x41F5 },
					{ LOOKUP, 105 }, { BITFLD, 106 }, { XOR, 0x61640311 },
					{ BITFLD, 107 }, { LOOKUP, 108 }, { LOOKUP, 109 },
					{ LOOKUP, 110 }, { XOR, 0x007044D3 }, { BITFLD, 111 },
					{ MULADD, 0x5C221625, 0x576F }, { LOOKUP, 112 },
					{ LOOKUP, 113 }, { XOR, 0x2D406BB1 },
					{ MULADD, 0x680B1F17, 0x12CD }, { BITFLD, 114 },
					{ MULADD, 0x12564D55, 0x32B9 },
					{ MULADD, 0x21A67897, 0x6BAB }, { LOOKUP, 115 },
					{ MULADD, 0x06405119, 0x7143 }, { XOR, 0x351D01ED },
					{ MULADD, 0x46356F6B, 0x0A49 },
					{ MULADD, 0x32C77969, 0x72F3 }, { BITFLD, 116 },
					{ LOOKUP, 117 }, { LOOKUP, 118 }, { BITFLD, 119 },
					{ LOOKUP, 120 }, { BITFLD, 121 },
					{ MULADD, 0x74D52C55, 0x5F43 }, { XOR, 0x26201CA8 },
					{ XOR, 0x7AEB3255 }, { LOOKUP, 122 },
					{ MULADD, 0x578F1047, 0x640B }, { LOOKUP, 123 },
					{ LOOKUP, 124 }, { BITFLD, 125 }, { BITFLD, 126 },
					{ XOR, 0x4A1352CF }, { MULADD, 0x4BFB6EF3, 0x704F },
					{ MULADD, 0x1B4C7FE7, 0x5637 },
					{ MULADD, 0x04091A3B, 0x4917 }, { XOR, 0x270C2F52 },
					{ LOOKUP, 127 }, { BITFLD, 128 }, { LOOKUP, 129 },
					{ BITFLD, 130 }, { MULADD, 0x127549D5, 0x579B },
					{ MULADD, 0x0AB54121, 0x7A47 }, { BITFLD, 131 },
					{ XOR, 0x751E6E49 }, { LOOKUP, 132 }, { LOOKUP, 133 },
					{ XOR, 0x670C3F74 }, { MULADD, 0x6B080851, 0x7E8B },
					{ XOR, 0x71CD789E }, { XOR, 0x3EB20B7B }, { BITFLD, 134 },
					{ LOOKUP, 135 }, { MULADD, 0x58A67753, 0x272B },
					{ MULADD, 0x1AB54AD7, 0x4D33 },
					{ MULADD, 0x07D30A45, 0x0569 },
					{ MULADD, 0x737616BF, 0x70C7 }, { LOOKUP, 136 },
					{ MULADD, 0x45C4485D, 0x2063 }, { BITFLD, 137 },
					{ XOR, 0x2598043D }, { MULADD, 0x223A4FE3, 0x49A7 },
					{ XOR, 0x1EED619F }, { BITFLD, 138 }, { XOR, 0x6F477561 },
					{ BITFLD, 139 }, { BITFLD, 140 }, { LOOKUP, 141 },
					{ MULADD, 0x4BC13C4F, 0x45C1 }, { XOR, 0x3B547BFB },
					{ LOOKUP, 142 }, { MULADD, 0x71406AB3, 0x7A5F },
					{ XOR, 0x2F1467E9 }, { MULADD, 0x009366D1, 0x22D1 },
					{ MULADD, 0x587D1B75, 0x2CA5 },
					{ MULADD, 0x213A4BE7, 0x4499 },
					{ MULADD, 0x62653E89, 0x2D5D }, { BITFLD, 143 },
					{ MULADD, 0x4F5F3257, 0x444F },
					{ MULADD, 0x4C0E2B2B, 0x19D3 } },
			{
					{ MULADD, 0x3F867B35, 0x7B3B }, // Table 4
					{ MULADD, 0x32D25CB1, 0x3D6D }, { BITFLD, 144 },
					{ MULADD, 0x50FA1C51, 0x5F4F }, { LOOKUP, 145 },
					{ XOR, 0x05FE7AF1 }, { MULADD, 0x14067C29, 0x10C5 },
					{ LOOKUP, 146 }, { MULADD, 0x4A5558C5, 0x271F },
					{ XOR, 0x3C0861B1 }, { BITFLD, 147 }, { LOOKUP, 148 },
					{ MULADD, 0x18837C9D, 0x6335 }, { BITFLD, 149 },
					{ XOR, 0x7DAB5033 }, { LOOKUP, 150 },
					{ MULADD, 0x03B87321, 0x7225 }, { XOR, 0x7F906745 },
					{ LOOKUP, 151 }, { BITFLD, 152 }, { XOR, 0x21C46C2C },
					{ MULADD, 0x2B36757D, 0x028D }, { BITFLD, 153 },
					{ LOOKUP, 154 }, { XOR, 0x106B4A85 }, { XOR, 0x17640F11 },
					{ LOOKUP, 155 }, { XOR, 0x69E60486 }, { LOOKUP, 156 },
					{ MULADD, 0x3782017D, 0x05BF }, { BITFLD, 157 },
					{ LOOKUP, 158 }, { XOR, 0x6BCA53B0 }, { LOOKUP, 159 },
					{ LOOKUP, 160 }, { LOOKUP, 161 }, { LOOKUP, 162 },
					{ XOR, 0x0B8236E3 }, { BITFLD, 163 },
					{ MULADD, 0x5EE51C43, 0x4553 }, { BITFLD, 164 },
					{ LOOKUP, 165 }, { LOOKUP, 166 }, { LOOKUP, 167 },
					{ MULADD, 0x42B14C6F, 0x5531 }, { XOR, 0x4A2548E8 },
					{ MULADD, 0x5C071D85, 0x2437 }, { LOOKUP, 168 },
					{ MULADD, 0x29195861, 0x108B }, { XOR, 0x24012258 },
					{ LOOKUP, 169 }, { XOR, 0x63CC2377 }, { XOR, 0x08D04B59 },
					{ MULADD, 0x3FD30CF5, 0x7027 }, { XOR, 0x7C3E0478 },
					{ MULADD, 0x457776B7, 0x24B3 }, { XOR, 0x086652BC },
					{ MULADD, 0x302F5B13, 0x371D }, { LOOKUP, 170 },
					{ MULADD, 0x58692D47, 0x0671 }, { XOR, 0x6601178E },
					{ MULADD, 0x0F195B9B, 0x1369 }, { XOR, 0x07BA21D8 },
					{ BITFLD, 171 }, { BITFLD, 172 }, { XOR, 0x13AC3D21 },
					{ MULADD, 0x5BCF3275, 0x6E1B },
					{ MULADD, 0x62725C5B, 0x16B9 },
					{ MULADD, 0x5B950FDF, 0x2D35 }, { BITFLD, 173 },
					{ BITFLD, 174 }, { MULADD, 0x73BA5335, 0x1C13 },
					{ BITFLD, 175 }, { BITFLD, 176 }, { XOR, 0x3E144154 },
					{ MULADD, 0x4EED7B27, 0x38AB }, { LOOKUP, 177 },
					{ MULADD, 0x627C7E0F, 0x7F01 },
					{ MULADD, 0x5D7E1F73, 0x2C0F }, { LOOKUP, 178 },
					{ MULADD, 0x55C9525F, 0x4659 }, { XOR, 0x3765334C },
					{ MULADD, 0x5DF66DDF, 0x7C25 }, { LOOKUP, 179 },
					{ LOOKUP, 180 }, { XOR, 0x16AE5776 }, { LOOKUP, 181 },
					{ LOOKUP, 182 }, { BITFLD, 183 }, { BITFLD, 184 },
					{ LOOKUP, 185 }, { MULADD, 0x4392327B, 0x7E0D },
					{ LOOKUP, 186 }, { MULADD, 0x3D8B0CB5, 0x640D },
					{ MULADD, 0x32865601, 0x4D43 }, { BITFLD, 187, 0 } } };
	// Btw: total saving by removing table 1 and unused args from
	// tables 2-5... 12,707 bytes down to 9,778.
}
