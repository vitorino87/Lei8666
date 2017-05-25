package lei8666;

import da.lei8666.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Questao extends QuestaoConector{
	//vari�vel utilizada para trabalhar com o m�todo checked
		private int z;
		
		//vari�vel para trabalhar com o m�todo randomizar;
		//private int k;
		
		//vari�vel para tratar a quantidade de quest�es
		//Essa vari�vel responde � quest�o: Quantas quest�es h� no aplicativo?
		//private final int h = 205;
		
		//vari�vel para trabalhar com o m�todo embaralhar
		private int[] w = new int[h];
		
		//Vari�veis para tratar com os objetos da tela2
		TextView tv;
		RadioButton[] rd = new RadioButton[5];
		//RadioButton rd1, rd2, rd3, rd4, rd5;
		Button botao, botao2, btnBuscar;
		EditText txtBuscar;
		
		//vari�veis para impedir que o random repita n�meros
		//private int[] e = new int[h];
		private int f=0;
		
		//vari�veis para tratar os R.string, isto �, as strings do programa
		//private int[] a = new int[h];
		//private int[][] b = new int[h][6];
		
		//m�todo para trabalhar com a tela2
				@Override
				protected void onCreate(Bundle savedInstanceState)
				{
					super.onCreate(savedInstanceState);		
					setContentView(R.layout.tela2);
					tv = (TextView)findViewById(R.id.textView1);  //ligando os objetos das telas �s vari�veis
					//rd1 = (RadioButton)findViewById(R.id.radio0);
					//rd2 = (RadioButton)findViewById(R.id.radio1);
					//rd3 = (RadioButton)findViewById(R.id.radio2);
					//rd4 = (RadioButton)findViewById(R.id.radio3);
					//rd5 = (RadioButton)findViewById(R.id.radio4);
					rd[0] = (RadioButton)findViewById(R.id.radio0);
					rd[1]=(RadioButton)findViewById(R.id.radio1);
					rd[2]=(RadioButton)findViewById(R.id.radio2);
					rd[3]=(RadioButton)findViewById(R.id.radio3);
					rd[4]=(RadioButton)findViewById(R.id.radio4);
					botao = (Button)findViewById(R.id.button1);
					botao2 = (Button)findViewById(R.id.button2);
					btnBuscar = (Button)findViewById(R.id.button3);
					txtBuscar = (EditText)findViewById(R.id.editText1);
					
										
					QuestaoAux.alimentador(w);
					QuestaoAux.embaralhar(w);
					
					//m�todo para trabalhar com o Random
					botao.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) 
						{
							if(f<h)
							{
								//o array w possui os n�meros das quest�es embaralhadas, a vari�vel f ir� orientar esse array, iniciando de 0 at� 98
								z=w[f];
								tv.setText(a[w[f]]);
								rd[0].setText(b[w[f]][0]);
								rd[1].setText(b[w[f]][1]);
								rd[2].setText(b[w[f]][2]);
								rd[3].setText(b[w[f]][3]);
								rd[4].setText(b[w[f]][4]);
								txtBuscar.setText(String.valueOf(w[f]));
								f++;  //incrementando a vari�vel f que armazena a posi��o do array que est� sendo percorrido.
							}				
						}
					});
					
					//m�todo para trabalhar com o bot�o Checar
					botao2.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							QuestaoAux.checked(z,b,rd,Questao.this);
						}
					});
					
					//m�todo para trabalhar com o bot�o Buscar
				btnBuscar.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						carregarQuestao(Integer.parseInt(txtBuscar.getText().toString()));
					}
				});
				}
				/**
				 * Serve para carregar a quest�o especificada na tela2
				 * @param questao
				 */
		public void carregarQuestao(int questao){
			z=questao;
			tv.setText(a[questao]);
			rd[0].setText(b[questao][0]);
			rd[1].setText(b[questao][1]);
			rd[2].setText(b[questao][2]);
			rd[3].setText(b[questao][3]);
			rd[4].setText(b[questao][4]);
		}

	
}
